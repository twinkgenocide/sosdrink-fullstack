export function crearProductos() {

    return <>
    <div id='content' class="main-content">
        <div class="admin-header">
            <h1>INGRESAR NUEVO PRODUCTO</h1>
        </div>
        <form class="productos-panel" id="producto-form">
            <div>
                <div>
                    <img id="product-image" />
                    <input type='file' id="product-up-image" name="image" accept="image/*" />
                </div>
                <div>
                    <label for="product-id">Código</label>
                    <input type="text" id="product-id" name="id" minlength="3" required />

                    <label for="product-name">Nombre</label>
                    <input type='text' id="product-name" name="name" maxlength="100" required />

                    <label for="product-price">Precio</label>
                    <input type='number' id="product-price" name="price" min="0" step="0.01" required />

                    <label for="product-stock">Stock</label>
                    <input type='number' id="product-stock" name="stock" min="0" required />

                    <label for='product-critstock'>Stock Crítico</label>
                    <input type='number' id="product-critstock" name="critstock" min="0" />

                    <select id="product-category" name="category" required>
                        <option value="alcohol">Alcohol</option>
                        <option value="tobacco">Tabaquería</option>
                        <option value="other">Otro</option>
                    </select>

                    <textarea id="product-description" name="description" maxlength="500"></textarea>
                </div>
            </div>
            <button type="submit">GUARDAR CAMBIOS</button>
        </form>
    </div>
    </>





}