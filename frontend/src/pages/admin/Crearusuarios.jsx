export function crearUsuarios() {

    return <>

    <div class="main-content">
        <div class="admin-header">
            <h1>INGRESAR NUEVO USUARIO</h1>
        </div>
        <div class="nuevo-usuario-box">
            <form id='nuevo-usuario-form'>
                <label for="run">RUN</label>
                <input type="text" id="run" name="run" required />

                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" required />

                <label for="apellidos">Apellidos</label>
                <input type="text" id="apellidos" name="apellidos" required />

                <label for="correo">Correo</label>
                <input type="email" id="correo" name="correo" required />

                <label for="tipo">Tipo de Usuario</label>
                <select id="tipo" name="tipo" required>
                    <option value="cliente">Cliente</option>
                    <option value="administrador">Administrador</option>
                    <option value="vendedor">Vendedor</option>
                </select>

                <label for="direccion">Dirección</label>
                <input type="text" id="direccion" name="direccion" required />

                <button type="submit" class="btn-guardar-usuario">Guardar Usuario</button>
            </form>
        </div>
    </div>
    </>





}