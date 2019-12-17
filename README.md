# testing-tehnopolis 2019 
cases for https://github.com/prohladenn

![Результат запуска тестов](https://github.com/prohladenn/final-project/raw/master/src/test/resources/testres.jpg)

## checkUserInfo (OverviewTest)
- open `Overview` page
  - check user name is "Valery Kovshov"
  - check user nickname "prohladenn"

## checkTypesOfFilter (RepositoryTest)
- open `Repository` page
- click button `Type`
  - check list of types has size 5
  - check every item is displayed and contains in [All,Sources,Forks,Archived,Mirrors]
  
## checkLanguagesOfFilter (RepositoryTest)
- open `Repository` page
- click button `Language`
  - check list of languages has size 8
  - check every item is displayed and contains in [All,Java,Scala,Kotlin,JavaScript,C++,CSS,C#]
  
## checkFindRepositoryByName (RepositoryTest)
- open `Repository` page
- send text "2019-highload-dht" in input
  - check repository list has size 1
  - check single repository item has title "2019-highload-dht"
  - check single repository item has language "Java"
  
## checkClearFilter (RepositoryTest)
- open `Repository` page
  - check default repository list size 29
- click button `Type`
- select type `Forks`
  - check repository list size 18
- click `Clear filter`
  - check repository list size 29
  
## checkDoesNotHaveAnyRepositoriesThatMatch (RepositoryTest)
- open `Repository` page
- send text "Polis Mail Ru Forever" in input
  - check repository list size 0
  - check blankslate text is displayed and contains "doesn’t have any repositories that match"
  
## checkFollowers (FollowersTest)
- open `Folovers` page
  - check folovers list has size 1
  - check single folover is "Darya Suhova"
