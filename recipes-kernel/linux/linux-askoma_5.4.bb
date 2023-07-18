require recipes-kernel/linux/linux-fslc.inc

SUMMARY = "Linux kernel for Energy Manager 1.3"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native"

KBUILD_DEFCONFIG = "askoma_defconfig"

SRCBRANCH = "5.4.x+askoma"
SRC_URI = "git://github.com/AskomaEmbedded/linux.git;branch=${SRCBRANCH};protocol=https"

SRCREV = "cd3a95f329f86002b57539acad19f606f7454e97"

LINUX_VERSION = "5.4.105"
LOCALVERSION = "-askoma"

COMPATIBLE_MACHINE = "imx6ull-em-r1"
