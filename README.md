# Reach
![version](https://img.shields.io/badge/Version-v1.0.1-brightgreen)
![paperMC-version](https://img.shields.io/badge/PaperMC-V1.16.1-blue)
![license-mit](https://img.shields.io/badge/License-MIT-purple)

Reach is a plugin that will provide addition features to the users gaming experience.

Do you need a speciality tool for making a build easier, looking for a weapon to deal a
bit more damage or even need better protection from those pesky mobs. This plugin will
provide just that, it will reach for your dreams.

This plugin applies performance and scalability in mind. Setting up is as easy as starting
up your server. Provides an extensive amount of customization options and settings which can
be changed to suit your server needs. Available at not cost and permissively licensed, so it
can remain free forever.

# :hammer: Building
Reach uses maven to handle dependencies and building.

##### :unlock: Requirements
* Java 8 JDK or newer
* [Paper](https://papermc.io/downloads)
  * Use features only available within Papers API.
* [SmartInvs plugin](https://www.spigotmc.org/resources/smartinvs-advanced-inventory-api.42835/)
  * API for the custom inventories(GUI) which access all custom items.

# :speech_balloon: Support
If you need support, please contact me directly. Working on an area where a hub will be feasible.

# :pencil: Contributing
##### :bug: Reporting Bugs 
Before reporting a bug or issues, please make sure the issue related or caused by Reach. Please 
double check, thank you!

If you're unsure, feel free contact me directly.

Bugs or issues should be reported using the [GitHub Issues tab](https://github.com/ProjectEzenity/Reach/issues).

##### :point_left: Pull Requests
If you make any changes or improvements to the plugin which you think would be beneficial to others,
please consider making a pull request to merge your changes back into the upstream project. (especially
if your changes are bug fixes!)

Reach loosely follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
Generally, try to copy the style of code found in the class you're editing.

##### :loop: Project Utilization
The project splits up into a few packages to make things easily navigable. 
* **Frameworks** - Reach has three frameworks currently: countdownFx, guiFx, particleFx. Each framework is
utilize throughout the project to accomplish varies tasks. However, frameworks can always improve and
offer additional features. If you have any ideas to make things work smoother or offer simplicity create
a pull request.
* **SmartsInvs** - The custom inventories created uses the SmartsInvs API. Where areas that require an
additional event listened not associated with the API, Bukkit Events are used instead.

# :scroll: License
Reach is licensed under the permissive MIT license. Please see [`LICENSE.txt`](https://github.com/ProjectEzenity/Reach/blob/master/LICENSE.txt) for more info.
