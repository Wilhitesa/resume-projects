
class Store:

    def __init__(self, name, typeStore, stock: {str: int}):
        self.name = name
        self.typeStore = typeStore
        self.stock = stock
        stores.append(self)

    def __str__(self):
        return self.name
    
    def addStock(self, newStock: {str: int}):
        for item in newStock.keys():
            if item in self.stock.keys():
                self.stock[item] += newStock[item]
            else:
                self.stock[item] = newStock[item]
    
    def __singleOrder(self, item: str):
        if item in self.stock.keys() and self.stock[item] > 0:
            self.stock[item] -= 1
            return item
    
    def order(self, item: str, amount: int = 1):
        orderList: [int] = []
        if item in self.stock.keys() and self.stock[item] >= amount:
            for _ in range(amount):
                orderList.append(self.__singleOrder(item))
        elif item in self.stock.keys() and 0 < self.stock[item] and self.stock[item] < amount:
            for _ in range(self.stock[item]):
                orderList.append(self.__singleOrder(item))
        if len(orderList) == 1:
            return orderList[0]
        else:
            return orderList