1. Для POST запроса на создание бронирования:
   http://localhost:8080/api/v1/booking

    Пример тела запроса в JSON:

    {
    "hotel_name": "Hillton",
    "room_type": "DOUBLE",
    "guests_list": [
    {
    "first_name": "Валерий",
    "last_name": "Земкин",
    "age": "29"
    },
    {
    "first_name": "Юлия",
    "last_name": "Земкина",
    "age": 29
    }
    ],
    "arrival": "2026-08-05T13:00:00",
    "departure": "2026-08-10T11:00:00",
    "meal_types": [
    "BREAKFAST",
    "DINNER"
    ]
    }

2. Для PUT запроса на изменение бронирования (времени заезда, выезда):
   http://localhost:8080/api/v1/booking/edit?id=0&arrival=2026-09-05T13:00:00&departure=2026-09-10T11:00:00
    
3. Для DELETE запроса на отмену (удаления) брони по id:
   http://localhost:8080/api/v1/booking/delete/0

4. Для GET запроса на получение списка всех бронирований:
   http://localhost:8080/api/v1/booking/all

5. Для GET запроса на получение списка всех доп. услуг в бронировании:
   http://localhost:8080/api/v1/booking/services/0