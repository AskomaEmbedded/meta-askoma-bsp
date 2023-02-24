part uuid ${devtype} ${devnum}:${distro_bootpart} uuid 
setenv bootargs_extra "${bootargs_extra} root=PARTUUID=${uuid}"

load ${devtype} ${devnum}:${distro_bootpart} ${loadaddr} /boot/Image
load ${devtype} ${devnum}:${distro_bootpart} ${fdt_addr_r} /boot/imx8mm-energy-manager.dtb

setenv bootargs "${bootargs_extra} rootwait rw"
booti ${loadaddr} - ${fdt_addr_r}
