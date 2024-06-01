document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('carForm');
    const carId = document.getElementById('carId');
    const marca = document.getElementById('marca');
    const modelo = document.getElementById('modelo');
    const cilindraje = document.getElementById('cilindraje');
    const precio = document.getElementById('precio');
    const carTable = document.getElementById('carTable').getElementsByTagName('tbody')[0];
    const messageDiv = document.getElementById('message');

    const apiUrl = 'http://localhost:8080/';

    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const car = {
            marca: marca.value,
            modelo: modelo.value,
            cilindraje: cilindraje.value,
            precio: precio.value
        };

        let response;
        if (carId.value) {
            response = await updateCar(carId.value, car);
        } else {
            response = await createCar(car);
        }

        form.reset();
        carId.value = '';
        if (response.ok) {
            showMessage('Operación exitosa', 'success');
        } else {
            showMessage('Error en la operación', 'error');
        }
        loadCars();
    });

    async function loadCars() {
        const response = await fetch(apiUrl);
        const cars = await response.json();
        carTable.innerHTML = '';
        cars.forEach(car => {
            const row = carTable.insertRow();
            row.insertCell(0).textContent = car.id;
            row.insertCell(1).textContent = car.marca;
            row.insertCell(2).textContent = car.modelo;
            row.insertCell(3).textContent = car.cilindraje;
            row.insertCell(4).textContent = car.precio;

            const actions = row.insertCell(5);
            const editButton = document.createElement('button');
            editButton.textContent = 'Editar';
            editButton.addEventListener('click', () => editCar(car));
            actions.appendChild(editButton);

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Eliminar';
            deleteButton.addEventListener('click', () => deleteCar(car.id));
            actions.appendChild(deleteButton);
        });
    }

    async function createCar(car) {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(car)
        });
        return response;
    }

    async function updateCar(id, car) {
        const response = await fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(car)
        });
        return response;
    }

    async function deleteCar(id) {
        const response = await fetch(`${apiUrl}/${id}`, {
            method: 'DELETE'
        });
        loadCars();
        return response;
    }

    function editCar(car) {
        carId.value = car.id;
        marca.value = car.marca;
        modelo.value = car.modelo;
        cilindraje.value = car.cilindraje;
        precio.value = car.precio;
    }

    function showMessage(message, type) {
        messageDiv.textContent = message;
        messageDiv.className = type;
        messageDiv.style.display = 'block';
        setTimeout(() => {
            messageDiv.style.display = 'none';
        }, 3000);
    }

    loadCars();
});
