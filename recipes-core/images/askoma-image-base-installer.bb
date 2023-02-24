do_rootfs[depends] += "askoma-image-base:do_image_complete"

CLIENT_INSTALLER_IMAGE_ROOTFS = "askoma-image-base-${MACHINE}"

require askoma-image-base-installer.inc
