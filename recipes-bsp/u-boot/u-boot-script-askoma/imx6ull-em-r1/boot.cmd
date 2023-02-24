load ${devtype} ${devnum}:${distro_bootpart} ${loadaddr} /boot/fitImage
imxtract ${loadaddr} fdt-imx6ull-kontron-n6411-s.dtb ${fdt_addr_r}
imxtract ${loadaddr} kernel-1 ${kernel_addr_r}

if test ${devtype} = ubi; then
    setenv bootargs_extra "${bootargs_extra} ubi.mtd=0 root=ubi0:${bootubivol} rootfstype=ubifs"
else
	part uuid ${devtype} ${devnum}:${distro_bootpart} uuid
	setenv bootargs_extra "${bootargs_extra} root=PARTUUID=${uuid}"
fi

setenv bootargs "${bootargs_extra} rootwait rw"

bootz ${kernel_addr_r} - ${fdt_addr_r}
