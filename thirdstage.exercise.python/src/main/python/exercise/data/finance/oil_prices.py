import pandas_datareader.data as web
import datetime

start = datetime.datetime(2015, 1, 1)
end = datetime.datetime(2019, 12,31)

print(start)

oil = web.DataReader('DCOILWTICO', 'fred', start, end)

print(oil.head())