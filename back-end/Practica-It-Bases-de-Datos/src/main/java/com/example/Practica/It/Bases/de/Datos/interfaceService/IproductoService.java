public interface IproductoService{
    public String save (productos productos);
    public List<productos>findAll();
    public List<productos>productosActivos();
    public Optional<productos>findOne(String id_productos);
    public int delete(String id_productos);
    List<productos>filtroProductos(String filtro);
    
}