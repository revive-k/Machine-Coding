import requests 
import json

API_KEY = "241cd2f857704fb38421571b825b578b"

def getHeadlines():
    country_code = input("Enter coutry code for top headlines: ")
    url = "https://newsapi.org/v2/top-headlines?country={country}&apiKey={key}".format(key = API_KEY, country = country_code)

    response = requests.get(url)
    news_json = json.loads(response.text)
    articles = news_json['articles']

    mycount = 1
    print("----------TOP HEADLINES---------")
    for article in articles:
        print(mycount, end="")
        print(" : " + article['title'])
        mycount += 1

def searchQuery():
    keyword = input("Enter key word to search:")
    url = "https://newsapi.org/v2/everything?q={word}&apiKey={key}".format(word = keyword, key = API_KEY)

    response = requests.get(url)
    news_json = json.loads(response.text)
    articles = news_json['articles']

    mycount = 1
    print("----------TOP NEWS FOR GIVEN WORD ----------")
    for article in articles:
        print(mycount, end="")
        print(" : " + article['title'])
        mycount += 1

def getSources():
    url = "https://newsapi.org/v2/sources?apiKey={key}".format(key = API_KEY)
    response = requests.get(url)
    news_json = json.loads(response.text)
    sources = news_json['sources']

    mycount = 1
    print("----------SOURCES ----------")
    for source in sources:
        print("Source:", end="")
        print(mycount)
        print(source['name'] + " : " + source['url'])
        print(source['description'])
        mycount += 1

def getOptions():
    while(True):
        print("Press 1 to get top headlines")
        print("Press 2 to search a query")
        print("Press 3 to get sources")
        option = int(input("Select option:"))
        if option == 1:
            getHeadlines()
        elif option == 2:
            searchQuery()
        elif option == 3:
            getSources()
        else:
            return

if __name__=="__main__":
    getOptions()