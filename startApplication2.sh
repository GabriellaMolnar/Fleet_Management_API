sudo docker build . -t fleetapp
sudo docker run --rm -it --name fleetcontainer --network=fleetnet -p 8080:8080 fleetapp

# run: sudo sh startapplication1.sh