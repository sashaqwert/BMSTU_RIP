# Пример:
# goods = [
#    {'title': 'Ковер', 'price': 2000, 'color': 'green'},
#    {'title': 'Диван для отдыха', 'price': 5300, 'color': 'black'}
# ]
# field(goods, 'title') должен выдавать 'Ковер', 'Диван для отдыха'
# field(goods, 'title', 'price') должен выдавать {'title': 'Ковер', 'price': 2000}, {'title': 'Диван для отдыха', 'price': 5300}

def field(items, *args):
    # Необходимо реализовать генератор
    current = 0
    while current < len(items):
        d = dict(list(items)[current])
        #print(d)
        allNome = True
        d_ = dict() #Словарь для возврата
        for i in range(len(args)):
            if d.get(args[i]) is None:
                continue
            allNome = False
            d_tmp = dict([(args[i], d.get(args[i]))])
            d_.update(d_tmp)
        if not allNome:
            yield d_
        current += 1


if __name__ == '__main__':
    # Словари
    dicteonary_1 = {'title': 'Диван для отдыха', 'price': 5300, 'color': 'black'}
    dicteonary_2 = {'title': 'Ковер', 'price': 2000, 'color': 'green'}
    dicteonary_3 = {'title': 'Квартира', 'price': 20000000, 'color': None}
    dicteonary_4 = {'title': 'Кошка', 'price': None, 'color': 'white'}
    # Список словарей - первый аргумент
    dicteonary_list = list()
    dicteonary_list.append(dicteonary_1)
    dicteonary_list.append(dicteonary_2)
    dicteonary_list.append(dicteonary_3)
    dicteonary_list.append(dicteonary_4)
    # print(dicteonary_list) #Проверка исходных данных
    # Вызов генератора и обращения к нему через итератор
    iter_1 =field(dicteonary_list, 'title', 'color')
    print(next(iter_1))
    print(next(iter_1))
    print(next(iter_1))
