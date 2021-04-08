#### Project Detail
implemented the assigned task using MVVM model, using latest version of LiveData api.
by using MVVM architecture, code is highly testable, maintainable.
there is no linkage b/w buisness logic, rest calls and ui. separation of concerns is the primary benefit.
i have used viewpager and retrofit2 to implement this task
and used constrained layout to design screen, though linearlayout can be used for a larger app, and defining multiple components and include them in the final layout,
if there are multiple use cases for those views.
when app runs it will show the first city, and user can swipe back/forth to check weather forecast of all four cities.
app. will load data when ever there is a swipe on page, to make sure user always get the latest weather forecast.





### Declarations & Assumptions
all data - such as API token & baseurl & city list is hardcoded in respective files - for simplicity
due to time constraints i have not displayed icons
due to time constraints i have not used any particular fonts
some fontsize might be differ as per provided image.
i have not implmented scenarios for no network connectivity or failure from REST API.
