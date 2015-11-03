# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  config.vm.box = "centos/7"

  config.vm.network :forwarded_port, :guest => 8080, :host => 8080
  config.vm.provision "shell", :path => "scripts/provision.sh"

  if RUBY_PLATFORM =~ /darwin/
    config.vm.synced_folder ".", "/vagrant", type: "rsync"
  else
    config.vm.synced_folder ".", "/vagrant"
  end

  config.vm.provider "virtualbox" do |v|
    v.memory = 1024
    v.cpus = 2

    # Set the timesync threshold to 10 seconds, instead of the default 20 minutes.
    v.customize ["guestproperty", "set", :id, "/VirtualBox/GuestAdd/VBoxService/--timesync-set-threshold", 10000]
  end
end
