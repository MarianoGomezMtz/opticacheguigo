package com.teamdev.opticacheguigo.opticacheguigo.controller;

import com.sun.prism.Material;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaMicas;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.CatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsCatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    private static final String VIEW_ARMAZON = "catalogoArmazon";
    private static final String VIEW_MICA = "catalogoMica";
    private static final String VIEW_INSUMO = "catalogoInsumo";
    private static final String VIEW_BASE_MATERIAL = "catalogoBaseMaterial";

    @Autowired
    ViewsInventarioService viewInventario;

    @Autowired
    ViewsCatalogoService viewCatalogoService;

    @Autowired
    CatalogoService catalogoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InventarioService inventarioService;

    @GetMapping({"/armazon", "/modifica/armazon", "/guardar/armazon"})
    public ModelAndView viewArmazon() {
        return new ModelAndView(VIEW_ARMAZON).addObject("codOperacion", 3)
                .addObject("mensaje", "")
                .addObject("productoError", new ProductoDto())
                .addObject("productos", inventarioService.productsByCatgory(1, 1, getUsuario()))
                .addObject("productosEliminados", inventarioService.productsByCatgory(1, 0, getUsuario()));
    }

    @GetMapping({"/micas", "/modifica/mica", "/guardar/mica"})
    public ModelAndView viewMica() {
        return new ModelAndView(VIEW_MICA).addObject("codOperacion", 3)
                .addObject("mensaje", "")
                .addObject("productoError", new ProductoDto())
                .addObject("micas", inventarioService.micasByMaterial(0, 1, getUsuario()))
                .addObject("micasEliminadas", inventarioService.micasByMaterial(0, 0, getUsuario()))
                .addObject("materiales", inventarioService.getMateriales(getUsuario(), 1));
    }

    @GetMapping({"/insumo", "/modifica/insumo", "/guardar/insumo"})
    public ModelAndView viewInsumo() {
        return new ModelAndView(VIEW_INSUMO).addObject("codOperacion", 3)
                .addObject("mensaje", "")
                .addObject("productoError", new ProductoDto())
                .addObject("productos", inventarioService.productsByCatgory(3, 1, getUsuario()))
                .addObject("productosEliminados", inventarioService.productsByCatgory(3, 0, getUsuario()));
    }

    @GetMapping({"/baseMaterial", "/modifica/baseMaterial", "/guardar/baseMaterial"})
    public ModelAndView viewBaseMaterial() {
        return new ModelAndView(VIEW_BASE_MATERIAL).addObject("mensaje", "")
                .addObject("productoError", new ProductoDto())
                .addObject("productos", inventarioService.getMateriales(getUsuario(), 1))
                .addObject("productosEliminados", inventarioService.getMateriales(getUsuario(), 0));
    }
	
/*	
	@GetMapping("/micas")
	public ModelAndView viewMicas() {
		
		return viewInventario.inventarioProducto(getUsuario(),2,VIEW_MICA);
	}
	*/

    @GetMapping("/insumos")
    public ModelAndView viewInsumos() {
        return viewInventario.inventarioProducto(getUsuario(), 3, VIEW_INSUMO);
    }

    @PostMapping(path = "/guardar/armazon")
    public ModelAndView guardarArmazon(@ModelAttribute ProductoDto producto) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.registroProducto(getUsuario(), producto, VIEW_ARMAZON);
    }

    @PostMapping(path = "/guardar/mica")
    public ModelAndView guardarMica(@ModelAttribute MicaDto mica) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.registroMica(getUsuario(), mica);
    }

    @PostMapping(path = "/guardar/insumo")
    public ModelAndView guardarInsumo(@ModelAttribute ProductoDto producto) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.registroProducto(getUsuario(), producto, VIEW_INSUMO);
    }

    @PostMapping(path = "/modifica/armazon")
    public ModelAndView modificarArmazon(@ModelAttribute ProductoDto producto) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.actualizaProducto(getUsuario(), producto, VIEW_ARMAZON);
    }

    @PostMapping(path = "/modifica/mica")
    public ModelAndView modificarMica(@ModelAttribute MicaDto mica) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.actualizaMica(getUsuario(), mica);
    }

    @PostMapping(path = "/modifica/insumo")
    public ModelAndView modificarInsumo(@ModelAttribute ProductoDto producto) {
        //ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
        return viewCatalogoService.actualizaProducto(getUsuario(), producto, VIEW_INSUMO);
    }

    @PostMapping(path = "/modifica/producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseGeneric modificarProducto(@ModelAttribute ProductoDto producto) {

        return catalogoService.actualizarProducto(catalogoService.converToMayus(producto), getUsuario());

    }

    @GetMapping("/detailproducto/{idProducto}")
    public ProductoDto detailProducto(@PathVariable(name = "idProducto") String idProducto) {
        //return productoService.getProductoId(idProducto);
        return inventarioService.detalleProducto(idProducto, getUsuario());
    }

    @GetMapping("/detailMica/{idMica}")
    public ConsultaMicas detailMica(@PathVariable(name = "idMica") String idMica) {
        //return productoService.getProductoId(idProducto);
        return inventarioService.detailMica(idMica, getUsuario());
    }


    @GetMapping(path = "/elimina/producto/{idProducto}/{status}")
    public ResponseGeneric eliminaProducto(@PathVariable(name = "idProducto") String idProducto, @PathVariable(name = "status") String status) {
        return catalogoService.eliminarProducto(idProducto, status, getUsuario());
    }

    @GetMapping(path = "/elimina/mica/{idMica}/{status}")
    public ResponseGeneric eliminaMica(@PathVariable(name = "idMica") String idMica, @PathVariable(name = "status") String status) {
        return catalogoService.eliminarMica(idMica, status, getUsuario());
    }

    @PostMapping(path = "/guardar/baseMaterial")
    public ModelAndView guardarBaseMaterial(@ModelAttribute MaterialDto producto) {
        return viewCatalogoService.registroBaseMaterial(getUsuario(), producto, VIEW_BASE_MATERIAL);
    }

    @GetMapping("/detailBaseMaterial/{id}")
    public MaterialDto detailBaseMaterial(@PathVariable(name = "id") String id) {
        return inventarioService.detailBaseMaterial(id, getUsuario());
    }

    @PostMapping(path = "/modifica/baseMaterial", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView modificarProducto(@ModelAttribute MaterialDto producto) {
        return viewCatalogoService.actualizarBaseMaterial(producto, getUsuario(), VIEW_BASE_MATERIAL);
    }

    @GetMapping(path = "/elimina/baseMaterial/{id}/{status}")
    public ResponseGeneric eliminaBaseMaterial(@PathVariable(name = "id") String id, @PathVariable(name = "status") String status) {
        return catalogoService.eliminarBaseMaterial(id, status, getUsuario());
    }

    public AuthHeader getUsuario() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        UsuarioPassEncrypt myPass = usuarioService.passEncryp(userDetails.getUsername());
        return new AuthHeader(userDetails.getUsername(), myPass.getPassEncrypt());

    }


}
