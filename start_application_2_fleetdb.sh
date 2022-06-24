sudo docker stop fleetdb
sudo docker run -it --rm --name fleetdb --network=fleetnet -e POSTGRES_DB=fleet -e POSTGRES_USER=fleetmanager -e POSTGRES_PASSWORD=fleetmanager -p 5433:5432 postgres:14.3-alpine


# run: sudo sh start_application_2_fleetdb.sh