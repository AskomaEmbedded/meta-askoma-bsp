def __after_init_askoma_bsp():
    PLATFORM_ROOT_DIR = os.environ['PLATFORM_ROOT_DIR']

    append_layers([ os.path.join(PLATFORM_ROOT_DIR, 'sources', p) for p in
                    [
                        'meta-askoma-bsp',
                        'meta-freescale',
                    ]])
    # FSL EULA
    eulas.accept['meta-freescale/EULA'] = 'ACCEPT_FSL_EULA = "1"'

run_after_init(__after_init_askoma_bsp)
