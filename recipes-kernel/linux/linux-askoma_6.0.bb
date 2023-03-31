require recipes-kernel/linux/linux-fslc.inc

SUMMARY = "Linux kernel for Energy Manager 2.0"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KBUILD_DEFCONFIG = "energy_manager_defconfig"

SRCBRANCH = "6.0.x+askoma"
SRC_URI = "git://github.com/AskomaEmbedded/linux.git;branch=${SRCBRANCH};protocol=https"

SRCREV = "2efc38cf19cbd2b8f4c140b98bf41ca19bb6cfcf"

LINUX_VERSION = "6.0.12"
LOCALVERSION = "-askoma"

COMPATIBLE_MACHINE = "imx8mm-em-r1"
