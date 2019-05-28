import requests
#string interpolation
#문자열에 변수값넣기
currency ='BTC'
url = f'https://api.bithumb.com/public/ticker/{currency}'
print(url)
# 요청결과 json -> dictionary 자료구조로 변환
response = requests.get(url).json()
print(response['data']['opening_price'])
print(response.get('data').get('opening_price'))

#classroom={'강보성':10,'이영걸':12}
#print(classroom['강보성'])