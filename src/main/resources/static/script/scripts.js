// JavaScript для открытия и закрытия модальных окон
const productModal = document.getElementById('productModal');
const contactModal = document.getElementById('contactModal');
const endMessage = document.getElementById('endMessage');
const menuItemAll = document.getElementById('menuItemAll');
const menuItemNew = document.getElementById('menuItemNew');
const menuItemSecondHand = document.getElementById('menuItemSecondHand');
let page = 0;
let lastActiveMenuItem = null; // Переменная для хранения активного пункта меню
let currentCategory = '';
let isLoading = false; // Флаг загрузки, чтобы избежать множественных запросов одновременно
let reachedEndOfList = false; // Флаг, указывающий, что конец списка достигнут

window.onscroll = function () {
    if ((window.innerHeight + window.pageYOffset) >= document.body.offsetHeight) {
        if (!isLoading && !reachedEndOfList) {
            isLoading = true;
            page++; // Увеличиваем номер страницы
            getCars(currentCategory, page);
        }
    }
};

document.addEventListener('DOMContentLoaded', () => {
    getCars('ALL'); // При загрузке страницы загружаем все товары
    menuItemAll.classList.add('active'); // Устанавливаем пункт меню "Все" как активный
    lastActiveMenuItem = menuItemAll; // Сохраняем ссылку на активный пункт меню
});

document.querySelectorAll('nav a').forEach(link => {
    link.addEventListener('click', function () {
        if (lastActiveMenuItem) {
            lastActiveMenuItem.classList.remove('active'); // Убираем активный класс с предыдущего пункта
        }
        link.classList.add('active'); // Добавляем активный класс к нажатому пункту
        lastActiveMenuItem = link; // Сохраняем последний активный пункт
        // Дополнительный код для отображения содержимого пункта меню...
    });
});

function openProductModal(productId) {
    fetch(`/v1/car-bot-api/cars/${productId}`)
        .then(response => response.json())
        .then(product => {
            document.getElementById('productName').innerText = product.brand + " " + product.model;
            document.getElementById('productDetails').innerHTML = `
                <img src="${product.image}" alt="${product.name}">
                <p>Год выпуска: ${product.year}</p>
                <p>Цвет: ${product.color}</p>
                <p>Мощность (л.с.): ${product.power}</p>
                <p>${product.description}</p>
                <p>Привод: ${product.fourWheelDrive ? '4WD' : '2WD'}</p>
                <p>Цена: ${product.price} млн рублей</p>
            `;
            productModal.style.display = "block";
        })
        .catch(error => console.error('Ошибка:', error));
}

document.getElementById('backButton').onclick = function () {
    // Ваш код для скрытия деталей товара и показа основного содержимого
    if (lastActiveMenuItem) {
        lastActiveMenuItem.click(); // Программно нажимаем на последний активный пункт меню
    }
};

function openContactModal() {
    contactModal.style.display = "block";
}

function closeContactModal() {
    contactModal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target === contactModal) {
        closeContactModal();
    }
}

menuItemAll.addEventListener('click', () => {
    reachedEndOfList = false
    clearProductsContainer();
    getCars('ALL');
    page = 0; // Сброс страницы на начальное значение
    lastActiveMenuItem = menuItemAll; // Обновление активного пункта меню
});

menuItemNew.addEventListener('click', () => {
    reachedEndOfList = false
    clearProductsContainer();
    getCars('NEW');
    page = 0; // Сброс страницы на начальное значение
    lastActiveMenuItem = menuItemNew; // Обновление активного пункта меню
});

menuItemSecondHand.addEventListener('click', () => {
    reachedEndOfList = false
    clearProductsContainer();
    getCars('SECOND_HAND');
    page = 0; // Сброс страницы на начальное значение
    lastActiveMenuItem = menuItemSecondHand; // Обновление активного пункта меню
});

function clearProductsContainer() {
    const productsContainer = document.getElementById('productsContainer');
    productsContainer.innerHTML = ''; // Удаление всех дочерних элементов
}

function getCars(category, page = 0) {
    currentCategory = category;
    const size = 10;
    fetch(`/v1/car-bot-api/cars?category=${category}&page=${page}&size=${size}`)
        .then(response => response.json())
        .then(data => {
            if (data.length === 0 || data.length < size) {
                // Если товаров нет или их количество меньше заданного размера страницы,
                // то считаем, что достигли конца списка и не выполняем повторную загрузку.
                isLoading = false; // Отключаем флаг загрузки
                // Можете здесь установить флаг, указывающий на конец списка
                reachedEndOfList = true;
            }
            const productsContainer = document.getElementById('productsContainer');
            data.forEach(product => {
                const productCard = `
                        <div class="product">
                            <img src="${product.image}" alt="${product.brand} ${product.model}">
                            <h2>${product.brand} ${product.model}</h2>
                            <p>Цена: ${product.price} млн рублей</p>
                            <button onclick="showProductDetails('${product.id}')">Подробнее</button>
                        </div>
                    `;
                productsContainer.insertAdjacentHTML('beforeend', productCard);
            });
            isLoading = false; // Сбрасываем флаг загрузки после добавления товаров
        })
        .catch(error => {
            console.error('Ошибка:', error);
            isLoading = false; // Сбрасываем флаг загрузки в случае ошибки запроса
            // Можете здесь установить флаг, указывающий на конец списка
            reachedEndOfList = true;
        });
}

document.querySelectorAll('.product button').forEach(button => {
    button.addEventListener('click', function () {
        const productId = this.getAttribute('data-id');
        showProductDetails(productId);
    });
});

function showProductDetails(productId) {
    fetch(`/v1/car-bot-api/cars/${productId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(product => {
            // Подготавливаем HTML для отображения деталей товара
            const detailsHtml = `
                <img src="${product.image}" alt="${product.description}" style="max-width: 100%; height: auto;">
                <h2>${product.year} ${product.color}</h2>
                <p>Мощность: ${product.power} л.с.</p>
                <p>${product.description}</p>
                <p>Цена: ${product.price} руб.</p>
            `;

            // Вставляем детали товара в контейнер на странице
            const detailsContainer = document.getElementById('productDetails');
            detailsContainer.innerHTML = detailsHtml;

            // Показываем детали товара и скрываем список товаров
            detailsContainer.style.display = 'block';
            document.getElementById('productsContainer').style.display = 'none';
            document.getElementById('backButton').style.display = 'flex'; // Показываем кнопку "Назад"
            document.querySelector('nav').style.display = 'none'; // Скрываем навигацию
        })
        .catch(error => {
            console.error('Ошибка при получении данных о товаре:', error);
        });
}

document.getElementById('backButton').onclick = function () {
// Скрытие деталей товара и кнопки "Назад"
    document.getElementById('productDetails').style.display = 'none';
    this.style.display = 'none'; // Скрываем кнопку "Назад"
    // Показываем навигационное меню
    document.querySelector('nav').style.display = 'flex'; // Или 'block', зависит от вашего изначального стиля
    // Возврат к отображению списка товаров (если нужно)
    document.getElementById('productsContainer').style.display = 'flex'; // Или 'block'
};