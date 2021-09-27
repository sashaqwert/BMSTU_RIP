# Здесь должна быть реализация декоратора
def print_result(func):
    def wrapped(arg=None):
        print(func.__name__)
        if arg is None:
            print(func())
            return func()
        else:
            print(func(arg))
            return func(arg)
        # return func

    return wrapped


@print_result
def test_1():
    return 1


@print_result
def test_2():
    return 'iu5'


@print_result
def test_3():
    return {'a': 1, 'b': 2}


@print_result
def test_4():
    return [1, 2]


if __name__ == '__main__':
    print('!!!!!!!!')
    var1 = test_1()
    test_2()
    test_3()
    test_4()
