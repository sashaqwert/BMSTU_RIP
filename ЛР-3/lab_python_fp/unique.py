# Итератор для удаления дубликатов
class Unique(object):
    def __init__(self, items, **kwargs):
        # Нужно реализовать конструктор
        # В качестве ключевого аргумента, конструктор должен принимать bool-параметр ignore_case,
        # в зависимости от значения которого будут считаться одинаковыми строки в разном регистре
        # Например: ignore_case = True, Aбв и АБВ - разные строки
        #           ignore_case = False, Aбв и АБВ - одинаковые строки, одна из которых удалится
        # По-умолчанию ignore_case = False
        self.items = items
        self.used_elements = set()
        self.index = 0
        if kwargs.get('ignore_case') is True:
            self.ignore_case = True
        else:
            self.ignore_case = False

    def __next__(self):
        while True:
            if self.index >= len(self.items):
                raise StopIteration
            else:
                current = self.items[self.index]
                check = current
                if self.ignore_case:
                    check = str(check).upper()
                self.index = self.index + 1
                if check not in self.used_elements:
                    if not self.ignore_case:
                        self.used_elements.add(current)
                    else:
                        self.used_elements.add(str(current).upper())
                    return current

    def __iter__(self):
        return self


if __name__ == '__main__':
    iter_3 = Unique([1, 1, 1, 2, 2, 2, 3])
    print(next(iter_3))
    print(next(iter_3))
    print(next(iter_3))
