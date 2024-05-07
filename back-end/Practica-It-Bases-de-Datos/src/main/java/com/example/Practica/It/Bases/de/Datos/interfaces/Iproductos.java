public interface Iproductos extends CrudRepository<productos,String> {
    @Query("SELECT m FROM productos m WHERE m. estado =?1")
    List<productos> filtroProductos(String filtro);

    @Query("SELECT m FROM productos m WHERE m. estado =?1")
    List<productos> productosActivos(String estado);
}