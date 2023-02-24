LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd"

inherit deploy

do_mkimage() {
    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "askoma bootscript" -d ${WORKDIR}/boot.cmd ${B}/boot.scr
}
do_mkimage[dirs] = "${B}"

addtask mkimage after do_configure before do_install

do_install() {
    install -Dm 0644 ${B}/boot.scr ${D}/boot/boot.scr
}

do_deploy() {
    install -Dm 0644 ${B}/boot.scr ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}
    cd ${DEPLOYDIR}
    ln -sf boot.scr-${MACHINE}-${PV}-${PR} boot.scr-${MACHINE}
}

addtask deploy after do_install

FILES:${PN} = "/boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot-default-script"
RPROVIDES:${PN} += "u-boot-default-script"

COMPATIBLE_MACHINE = "(imx6ull-em-r1|imx8mm-em-r1)"
