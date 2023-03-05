[![Build Status](https://travis-ci.org/navicore/lots-of-names.svg?branch=master)](https://travis-ci.org/navicore/lots-of-names)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9847820a8b7040268c808b45e597393c)](https://www.codacy.com/app/navicore/lots-of-names?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=navicore/lots-of-names&amp;utm_campaign=Badge_Grade)
# Lots of Names

Generate fun safe-for-work names from input strings.  Collisions are about 1 every 15,000 to 20,000 inputs.

Useful for assigning fake but consistently calculable names to test data as well as tokenized PII data where you want to study customer behavior but not spy on anyone. CAUTION - anonymizing PII data is deceptively hard to protect against correlation attacks - de-anonymizing.

Creates reproducible human-ish names with the help of `scaala.util.hashing.MurmurHash3`.

Reproducibility is tied to the major version number of a release.

Sample Names from UUIDs:

```
Hadjer Geary
Iris Rocky Idelisa
Zelek Amphoricity
Bendell Lean Lynchj
Mcgavin Macpherson Kreischer
Cheney Checker Eurton
Añes Foucault
Alexander Washington Colasuonno
Gretzky Tune Inzer
Dudley Kluber
Scolari Zody
Houdek Chocolate
Alken Beauty
Moslim Distributary
Watson Lister Dair
Charles Canalise
Jaeckel Decio
Zeh Beadle Cun
Undevilish Alfonso Creamer
Pitts Leisinger
```

# INSTALL

Binaries available via [maven](https://mvnrepository.com/artifact/tech.navicore/lotsofnames): - check for latest version

Update your `build.sbt` dependencies with:
```scala
// https://mvnrepository.com/artifact/tech.navicore/lotsofnames
libraryDependencies += "tech.navicore" %% "lotsofnames" % "3.0.4"
```

## USAGE

UUID to readable name

```scala
    val id = "7AC7E2AD-50E2-4515-8392-A83B38CE9144"
    val name = LotsOfPeople(id)
    assert(name == "Aldrin Cricket Heisser")
```

or alias generator

```scala
    val name = "Edward John Sweeney"
    val alias = LotsOfPeople(name)
    assert(alias == "Bili Aikman")
```

or test it via curl with the lots-of-names-api deployment:

```console
curl -d '[{"sourceId": "7AC7E2AD-50E2-4515-8392-A83B38CE9144"}]' -H "Content-Type: application/json" -X POST https://lotsofnames.navicore.tech/names
```

another:

```scala
    val data = "1010020202993993938484885858577583939392929393AAKDKDKDKDKDKDKDKDKDD"
    val id = LotsOfPeople(data)
    assert(id == "Homeothermous Mykhaylo")
```

## OPS

* Github Actions are triggered on PRs to run the tests.
* Releases are built and published to Maven Central via Github Actions.
