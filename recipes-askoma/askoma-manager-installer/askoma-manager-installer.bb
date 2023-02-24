SUMMARY = "Askoma Manager NAND installer"
LICENSE = "CLOSED"

SRC_URI = "\
    file://${BPN} \
    file://${BPN}.service \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = "${PN}.service"

do_install() {
    install -Dm 0755 ${WORKDIR}/${PN} ${D}/${bindir}/${PN}
    install -Dm 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/${PN}.service
    sed -i -e 's,@SPL_BINARY@,${SPL_BINARY},g' \
        -e 's,@UBOOT_BINARY@,${UBOOT_BINARY},g' \
        ${D}/${bindir}/${PN}
}

RDEPENDS:${PN} += "\
    bmap-tools \
    curl \
    mtd-utils \
    mtd-utils-ubifs \
    xz \
"
