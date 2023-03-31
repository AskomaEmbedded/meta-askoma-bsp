require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Energy Manager boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit imx-boot-container fsl-u-boot-localversion

DEPENDS:append = " \
     bc-native \
     dtc-native \
     flex-native \
     gnutls-native \
     lzop-native \
     bison-native \
     python3-setuptools-native \
"

PROVIDES += "u-boot"

SRCBRANCH = "2022.10+askoma"
SRC_URI = " \
    git://github.com/AskomaEmbedded/u-boot.git;branch=${SRCBRANCH};protocol=https \
    file://fw_env.config \
"

SRCREV = "9755e2b903cb4601484bb2bc494f594f41692d94"

PV = "2022.10+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "imx8mm-em-r1"
