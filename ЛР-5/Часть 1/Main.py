import MySQLdb

db = MySQLdb.connect(
    host="SRV2022",
    user="admin",
    passwd="1234567890",
    db="rip_first_db"
)

if __name__ == '__main__':
    c = db.cursor()
    c.execute("INSERT INTO animals (type, name) VALUES (%s, %s);", (input('Тип животного: '), input('Кличка животного: ')))
    db.commit()
    c.close()
    db.close()