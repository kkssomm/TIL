import requests
# url
token = '626629371:AAHg9pEC_BBYy2FgVLoeslcOr25lTwf5ndk'
base_url = f'https://api.telegram.org/bot{token}'

# 요청내용
chat_id = 978954343
text='안녕하세요?'
url =f'{base_url}/sendMessage?chat_id={chat_id}&text={text}'

#요청보내기
requests.get(url)