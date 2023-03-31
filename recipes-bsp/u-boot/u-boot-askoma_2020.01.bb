# Copyright (C) 2012-2019 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

inherit fsl-u-boot-localversion

require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Askoma based boards"
DEPENDS += "bison-native bc-native dtc-native lzop-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

SRC_URI = "git://github.com/AskomaEmbedded/u-boot.git;protocol=https;branch=${SRCBRANCH} \
           file://fw_env.config \
"
SRCREV = "a81ba943d8d3901984c38fc49506ad1d3eb06461"
SRCBRANCH = "2020.01+askoma"

PROVIDES += "u-boot"

PV .= "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(imx6ull-em-r1)"
