SUMMARY = "Checksumming Copy on Write Filesystem utilities"
DESCRIPTION = "Btrfs is a new copy on write filesystem for Linux aimed at \
implementing advanced features while focusing on fault tolerance, repair and \
easy administration. \
This package contains utilities (mkfs, fsck, btrfsctl) used to work with \
btrfs and an utility (btrfs-convert) to make a btrfs filesystem from an ext3."

HOMEPAGE = "https://btrfs.wiki.kernel.org"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fcb02dc552a041dee27e4b85c7396067"
SECTION = "base"
DEPENDS = "util-linux attr e2fsprogs lzo acl"

SRCREV = "194aa4a1bd6447bb545286d0bcb0b0be8204d79f"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/mason/btrfs-progs.git"

S = "${WORKDIR}/git"

PV = "0.20+git${SRCPV}"

SRC_URI += "file://weak-defaults.patch"
SRC_URI += "file://btrfs-progs-fix-parallel-build.patch"
SRC_URI += "file://btrfs-progs-fix-parallel-build2.patch"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

BBCLASSEXTEND = "native"
