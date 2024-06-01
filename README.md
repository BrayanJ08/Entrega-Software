Descripción del Proyecto
El proyecto Front proporciona una interfaz de usuario para interactuar con el backend y realizar diversas operaciones relacionadas con la gestión de carros.

Características
Interfaz de usuario intuitiva y amigable.
Integración con el backend para obtener y enviar datos.
Funcionalidades para listar, crear, editar y eliminar carros.
Diseño responsivo para adaptarse a diferentes dispositivos.
Tecnologías Utilizadas
React.js para el desarrollo del frontend.
HTML y CSS para la estructura y estilos de la interfaz de usuario.
JavaScript para la lógica de interacción del usuario.
Requisitos Previos
Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

Node.js (versión X o superior)
npm (Node Package Manager)
Instalación y Configuración
Sigue estos pasos para instalar y configurar el proyecto:

Clona el repositorio desde GitHub:
bash
Copy code
git clone https://github.com/Maicolmontoya12/front.git
Navega al directorio del proyecto:
bash
Copy code
cd front
Instala las dependencias del proyecto:
bash
Copy code
npm install
Configura cualquier variable de entorno necesaria según sea necesario.
Ejecución
Para ejecutar el proyecto, sigue estos pasos:

Inicia el servidor de desarrollo:
bash
Copy code
npm start
Abre tu navegador web y navega a la siguiente URL:
arduino
Copy code
http://localhost:3000

Métodos de la API:
GET /carros: Obtiene todos los carros.

Resumen: Obtener todos los carros.
Descripción: Devuelve una lista de todos los carros.
Respuesta:
200: Lista de carros obtenida con éxito.
Content-Type: application/json
POST /carros: Crea un nuevo carro.

Resumen: Crear un nuevo carro.
Descripción: Crea un nuevo carro con los datos proporcionados.
RequestBody:
Requerido: Sí
Content-Type: application/json
GET /carros/{id}: Obtiene un carro por su ID.

Resumen: Obtener un carro por ID.
Descripción: Devuelve un carro específico basado en su ID.
Parámetros:
Path: id: string (requerido)
Respuesta:
200: Carro obtenido con éxito.
404: Carro no encontrado.
PUT /carros/{id}: Actualiza un carro existente por su ID.

Resumen: Actualizar un carro por ID.
Descripción: Actualiza los detalles de un carro específico.
Parámetros:
Path: id: string (requerido)
RequestBody:
Requerido: Sí
Content-Type: application/json
Respuesta:
200: Carro actualizado con éxito.
404: Carro no encontrado.
DELETE /carros/{id}: Elimina un carro por su ID.

Resumen: Eliminar un carro por ID.
Descripción: Elimina un carro específico basado en su ID.
Parámetros:
Path: id: string (requerido)
Respuesta:
204: Carro eliminado con éxito.
404: Carro no encontrado.
