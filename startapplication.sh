flyway clean
sudo docker stop fleetdb
sudo docker network rm fleetnet

sudo docker network create fleetnet
sudo docker run -it --rm --name fleetdb --network=fleetnet -e POSTGRES_DB=fleet -e POSTGRES_USER=fleetmanager -e POSTGRES_PASSWORD=fleetmanager -p 5433:5432 postgres:14.3-alpine
sudo docker build . -t fleetapp
sudo docker run --rm -it --name fleetcontainer --network=fleetnet -p 8080:8080 fleetapp


# sh indítása: sudo sh startapplication.sh