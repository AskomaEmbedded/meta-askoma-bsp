# Askoma Yocto Project BSP

## Introduction

The purpose of this document is to provide all information needed to build a basic Linux image for a Askoma board using this BSP for Yocto Project.

### What is Yocto Project?

The Yocto Project is an open-source collaboration project that provides a set of tools and resources to help developers create custom Linux-based systems for embedded devices. It enables developers to build, customize, and deploy Linux distributions tailored specifically for their hardware platform or device. The project includes a build system, a set of tools, and a reference distribution that provides a starting point for building custom Linux distributions.

For more information, visit [Yocto Project page](https://www.yoctoproject.org/).

### What is BSP?

A Board Support Package (BSP) encompasses a set of data that outlines the necessary steps to support a specific hardware platform. The BSP contains details about the hardware features that are present on the device, kernel configuration information, and any extra hardware drivers that may be needed. Additionally, the BSP specifies any supplementary software components that are required to enable both essential and optional platform features, along with a generic Linux software stack.

### Supported hardware

This BSP supports the following hardware:

| Yocto Project Machine  | Askoma Hardware                                     |
|------------------------|-----------------------------------------------------|
| imx6ull-em-r1          | Energy Manager 1.2 and 1.3 (based on NXP i.MX 6ULL) |
| imx8mm-em-r1           | Energy Manager 2.0 (based on NXP i.MX 8MM)          |

## BSP Layer Dependency

This BSP layer depends on third-party layers. So this layers must be added to the project:

| Yocto Project Layer                               | Branch     |
|---------------------------------------------------|------------|
| https://github.com/openembedded/openembedded-core | Kirkstone  |
| https://github.com/Freescale/meta-freescale       | Kirsktone  |

## Images provided by this BSP

### `askoma-image-base`

This is a basic image which contains simple resources and an SSH server to access the system as it doesn't have a graphical UI.

The image can run directly from the SD Card or internal storage.

### `askoma-image-base-installer`

This image has the only purpose to install the `askoma-image-base` into the internal storage (eMMC or NAND).

#### Installing the image

To install the image, follow these steps:

1. Generate a `askoma-image-base-installer`;
2. Burn a micro SD card with the image and insert into micro SD card slot;
3. Turn on the board and you will see a LED blinking;
4. When it get ready the LED will stop blinking and stay on;
5. Reboot the board without the SD card;
6. Ready. The image will boot automatically.

## Askoma Reference Platform

* [Askoma Embedded Platform](https://github.com/AskomaEmbedded/askoma-embedded-linux-platform)
