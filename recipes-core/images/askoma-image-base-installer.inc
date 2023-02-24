DESCRIPTION = "Install Askoma Image to device"
LICENSE = "CLOSED"

# Avoid installation of syslog
BAD_RECOMMENDATIONS += "busybox-syslog"

# Avoid static /dev
USE_DEVFS = "1"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL = "\
    askoma-manager-installer \
"

remove_fstab() {
   rm -f ${IMAGE_ROOTFS}/${sysconfdir}/fstab
}

copy_imx6_installer_files() {
    local dest_dirname=installer-data
    local dest=${IMAGE_ROOTFS}/$dest_dirname
    mkdir -p $dest

    cp ${DEPLOY_DIR_IMAGE}/${SPL_BINARY} $dest/${SPL_BINARY}
    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_BINARY} $dest/${UBOOT_BINARY}
    cp ${DEPLOY_DIR_IMAGE}/${CLIENT_INSTALLER_IMAGE_ROOTFS}.ubi $dest/rootfs.ubi
}

copy_imx8_installer_files() {
    local dest_dirname=installer-data
    local dest=${IMAGE_ROOTFS}/$dest_dirname
    mkdir -p $dest

    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_BINARY} $dest/${UBOOT_BINARY}
    cp ${DEPLOY_DIR_IMAGE}/${CLIENT_INSTALLER_IMAGE_ROOTFS}.wic.bmap $dest/rootfs.wic.bmap
    cp ${DEPLOY_DIR_IMAGE}/${CLIENT_INSTALLER_IMAGE_ROOTFS}.wic.xz $dest/rootfs.wic.xz
}

ROOTFS_POSTPROCESS_COMMAND:imx6ull-em-r1 = "remove_fstab; copy_imx6_installer_files; "

ROOTFS_POSTPROCESS_COMMAND:imx8mm-em-r1 = "remove_fstab; copy_imx8_installer_files; "

IMAGE_FSTYPES:imx6ull-em-r1 = "wic.gz wic.bmap"
