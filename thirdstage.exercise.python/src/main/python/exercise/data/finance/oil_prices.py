import datetime
import pandas_datareader.data as dr
import matplotlib.pyplot as plt
import seaborn as sns

kospi = dr.DataReader('^KOSPI', 'stooq')
sns.lineplot(x=kospi.index, y="Close", data=kospi)
plt.show()

start = datetime.datetime(2015, 1, 1)
end = datetime.datetime(2019, 12, 31)

oil = dr.DataReader('DCOILWTICO', 'fred', start, end)

print(oil.head())