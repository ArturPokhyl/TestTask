Для того щоб код запрацював треба підставити деякі свої параметри:
1) в api.properties треба підставити свої данні для
- public.key=
- secret.key=
- base.url=(без ендпоінту /init)
- status.url=(без ендпоінту /status)
2) card.properties треба підставити дані своєї тестової карти для успішної оплати
3) create_payment_page_request.json - тут треба підставити саме JSON для запиту на створення сторінки
4) status_request.json - так само як і в create_payment_page_request.json треба підставити JSON для отримання статусу
