import chupetin from '../../images/Header Icons/categoriasImagenesMock/chupetin.jpeg';

const productosMock = () => {
    let array = [];
    generarProductos(100, array);
    return array;
};

const generarProductos = (cantidad, array) => {
    const categoriasMock = ['analgesico', 'perfumeria', 'limpieza', 'copetin', 'golosinas', 'galletas', 'comestible', 'filos'];
    const nombresMock = ['chupetin', 'galletas', 'caramelos', 'chocolate', 'golosinas'];
    
    // Cambia el índice inicial a 0
    for (let i = 0; i < cantidad; i++) {
        array.push({
            id: i + 1, // Si quieres que el id comience desde 1
            nombre: nombresMock[Math.floor(Math.random() * nombresMock.length)],
            descripcion: `Lorem ipsum dolor sit amet, consectetur adipiscing elit.`,
            imagen: chupetin,
            marca: `Marca ${i + 1}`, // Cambiar a i + 1 para mantener la correlación con el id
            categoria: categoriasMock[Math.floor(Math.random() * categoriasMock.length)]
        });
    }
}

export default productosMock;
