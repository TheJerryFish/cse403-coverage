# Coverage Exercise - Triangle

This is a software testing exercise that focuses on unit testing and test effectiveness using code coverage criteria. Students learn to create comprehensive test suites that achieve different types of coverage for a simple Triangle classification program.

**Original Exercise**: This exercise was originally developed by Professor Rene Just. The original version can be found at: https://bitbucket.org/rjust/coverage/src/master/

## Overview

The Triangle program classifies triangles based on the lengths of their three sides. Students must create test suites that achieve specific coverage criteria:

- **SC** (Statement Coverage) - Tests must execute all statements in the code
- **DC** (Decision Coverage) - Tests must exercise all decision branches  
- **CC** (Condition Coverage) - Tests must evaluate all conditions to both true and false

## Quick Start

1. **Run tests with coverage**: `./gradlew test`
2. **View coverage report**: Open `build/reports/jacoco/test/html/index.html` in your browser
3. **Tag your progress**: Use `git tag SC`, `git tag DC`, etc. after each coverage milestone
4. **Create submission**: Use `tar -czf coverage.tar.gz cse403-coverage/` to create your submission archive
