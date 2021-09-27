

if __name__ == '__main__':
    data = [4, -30, 100, -100, 123, 1, 0, -1, -4]

    result = sorted(data, reverse=True)
    print(result)

    result_with_lambda = sorted(data, key=lambda n: n, reverse=True)
    print(result_with_lambda)
