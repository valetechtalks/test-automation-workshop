import yaml
from orator import Model
from orator import DatabaseManager

with open('orator.yml', 'r') as stream:
    config = yaml.safe_load(stream)['databases']

db = DatabaseManager(config)

Model.set_connection_resolver(db)
