package com.teamdev.opticacheguigo.opticacheguigo.service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;

public interface CatalogoService {
    ResponseGeneric registrarProducto(ProductoDto producto, AuthHeader userSession);

    ResponseGeneric actualizarProducto(ProductoDto producto, AuthHeader userSession);

    ResponseGeneric actualizarMica(MicaDto mica, AuthHeader userSession);

    ResponseGeneric eliminarProducto(String idProducto, String status, AuthHeader userSession);

    ResponseGeneric eliminarMica(String idMica, String status, AuthHeader userSession);

    ProductoDto converToMayus(ProductoDto producto);

    MicaDto converToMayusMica(MicaDto mica);

    ResponseGeneric registraMica(MicaDto mica, AuthHeader userSession);

}
