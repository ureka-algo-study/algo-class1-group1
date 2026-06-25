from bisect import bisect_left, bisect_right

def count_by_range(arr, left_value, right_value):
    return bisect_right(arr, right_value) - bisect_left(arr, left_value)

def solution(words, queries):
    answer = []

    # 길이별 단어 저장
    arr = [[] for _ in range(10001)]
    rev_arr = [[] for _ in range(10001)]

    for word in words:
        arr[len(word)].append(word)
        rev_arr[len(word)].append(word[::-1])

    # 정렬
    for i in range(10001):
        arr[i].sort()
        rev_arr[i].sort()

    for query in queries:
        length = len(query)

        # 접두사가 ?인 경우
        if query[0] == '?':
            reversed_query = query[::-1]

            left = reversed_query.replace('?', 'a')
            right = reversed_query.replace('?', 'z')

            answer.append(
                count_by_range(rev_arr[length], left, right)
            )

        # 접미사가 ?인 경우
        else:
            left = query.replace('?', 'a')
            right = query.replace('?', 'z')

            answer.append(
                count_by_range(arr[length], left, right)
            )

    return answer
