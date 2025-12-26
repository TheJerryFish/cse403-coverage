# In-class exercise Coverage-based testing: Instructions

## High-level goal
The high-level goals of this exercise are to 

- Learn about systematic unit testing 
- Reason about test quality, using code coverage criteria.

## Setup

1. Make sure **[Git](https://git-scm.com/)** is installed.

2. **Java Requirements**: This project requires Java JDK version 8-21 (Java 22 is not supported).
   - **On UW CSE machines** (like attu): Java is already configured correctly - no setup needed!
   - **On your personal machine**: See Java setup instructions below.

3. Test your setup: compile and test the Triangle program.

4. Compute the coverage report, per the instructions below.

### Java Setup (Personal Machines Only)

**If you're using UW CSE machines like attu, skip this section - Java is already configured correctly.**

#### Checking Your Java Version
```bash
# Check your current Java version
java -version
javac -version
```

#### If You Need a Different Java Version

**Option 1: Use UW CSE machines (Recommended)**
- SSH into attu: `ssh your_netid@attu.cs.washington.edu`
- Java is already configured correctly on CSE machines

**Option 2: Install/Switch Java Version on Your Machine**

**macOS/Linux/Windows WSL:**
```bash
# Using SDKMAN (recommended for managing multiple Java versions)
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 17.0.2-open
sdk use java 17.0.2-open

# Or using package managers
# Ubuntu/Debian (WSL): sudo apt install openjdk-17-jdk
# macOS with Homebrew: brew install openjdk@17
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64  # Adjust path as needed
```

**Windows (PowerShell):**
```powershell
# Using Chocolatey
choco install openjdk17

# Or download from Oracle/OpenJDK and set JAVA_HOME manually
# Set environment variable in PowerShell:
$env:JAVA_HOME = "C:\Program Files\OpenJDK\jdk-17.0.2"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
```

**Manual Installation:**
- Download OpenJDK 17 from [https://adoptium.net/](https://adoptium.net/)
- Set `JAVA_HOME` environment variable to the installation directory
- Add `$JAVA_HOME/bin` (or `%JAVA_HOME%\bin` on Windows) to your PATH

### Running Tests and Coverage Analysis

**macOS/Linux/Windows WSL:**
```bash
./gradlew test
```

**Windows (PowerShell):**
```powershell
.\gradlew.bat test
```

This compiles the code, runs all tests, and generates coverage reports.

**View the coverage report**:
- **On UW CSE machines** (like attu): Visit https://homes.cs.washington.edu/~$USER/jacoco_report 
  (replace $USER with your CSE NetID)
- **On other systems**: Open `build/reports/jacoco/test/html/index.html` in your browser


## Instructions

0. **Read the entire assignment and ask any clarifying questions that you might have.**

### Coverage-based testing

1. Familiarize yourself with the triangle program (`src/triangle/Triangle.java`). 

2. Familiarize yourself with the example test suite (`test/triangle/TriangleTest.java`).

3. Compute the coverage report, per the instructions above.
   Then, **inspect** the coverage report it generates.

4. Develop **4 test suites** (i.e., add tests to the `testTable` method in `TriangleTest.java`)
   that satisfy the following coverage criteria:
    * **SC**: Statement coverage
    * **DC**: Decision coverage
    * **CC**: Condition coverage
    * **MCDC**: Modified condition and decision coverage
    
    You may reuse tests between test suites.
    **For each test suite**, make a **commit and tag it**.
    Use SC, DC, CC, and MCDC as tag names for the respective coverage criteria.
    
    **Important: Commit and tag after completing each coverage criterion, or you will lose your previous progress when working on the next criterion.**

5. Skip the dummy test (i.e., add an `@Disabled` annotation to the testDummy
   method) and regenerate the coverage report. (Note the difference in the
   coverage report, which is related to question 1 below.)
   * The documentation for the `@Disabled` annotation is available
   [here](https://junit.org/junit5/docs/5.0.0-M2/api/org/junit/jupiter/api/Disabled.html).
   
   **Important for Submission: Remove the `@Disabled` annotation before creating your final submission. The autograder needs all tests to run properly.**

## Questions
1. Jacoco instruments the Java byte code for measuring code coverage.

   a. For the purpose of measuring code coverage, state two advantages for
      instrumenting source code and two advantages for instrumenting
      Java byte code or an intermediate representation more generally.

   b. Which instrumentation approach is preferable? Briefly explain why?

2. Which coverage criterion does Jacoco’s branch coverage correspond to? Why?

3. Give a definition of "*test redundancy*", using a code coverage criterion and
   provide an example of a redundant test for one of your test suites
   (explicitly state which existing test in your test suite is redundant with
   the example you provide).
   Given your definition of test redundancy, would you remove redundant tests
   from an existing test suite? Briefly explain why or why not.

4. Consider the following two, functionally equivalent code snippets
   (a, b, and c are boolean inputs):

   Version 1
   ```
   o1 = (a | b) & c
   ```

   Version 2
   ```
   t1 = a | b
   o2 = t1 & c
   ```

   a. Provide a **minimum** MCDC-adequate test suite for each Version.

   b. For each of the two test suites, is it MCDC-adequate for the other version?

   c. Can you create two MCDC-adequate test suites of equal size -- one being
      adequate for Version 1 and one being adequate for Version 2 but not
      Version 1?

   d. Summarize your observations from the three prompts above (4a--4c) and
      briefly discuss guarantees and/or implications w.r.t. adequacy and code
      structure.

## Deliverables
1. **Written Portion**: Answer the four questions above directly on **Gradescope**. Please add all group members in your submission.

2. **Code Portion**: An archive (tar.gz) of your git repository, which contains the four tagged commits for your developed test suites. Submit this to **Gradescope**.

### Steps for turn-in
One team member should submit both portions to **Gradescope**:
- Answer the written questions directly in the "In-class Exercise: Coverage (Written)" assignment
- Upload the code archive to the "In-class Exercise: Coverage (Code)" assignment

### Creating Your Submission Archive

**macOS/Linux/Windows WSL:**
```bash
# From the parent directory of your coverage folder:
tar -czf coverage.tar.gz coverage/
```

**Windows (PowerShell):**
```powershell
# From the parent directory of your coverage folder:
tar -czf coverage.tar.gz coverage/
```

This creates a compressed archive containing your entire git repository with all tagged commits.

## Helpful Tips

### Git Commands
To tag a commit after completing each coverage criterion, you can use:

```bash
git tag SC    # After completing Statement Coverage
git tag DC    # After completing Decision Coverage  
git tag CC    # After completing Condition Coverage
git tag MCDC  # After completing MCDC
```


### Troubleshooting
- **Permission errors on gradlew**: 
  - macOS/Linux/Windows WSL: `chmod +x gradlew`
  - Windows PowerShell: Use `.\gradlew.bat` instead of `./gradlew`
- **Java version issues**: Use UW CSE machines (attu) or follow Java setup instructions above
- **Clean builds**: Use `./gradlew clean test` (macOS/Linux/WSL) or `.\gradlew.bat clean test` (Windows PowerShell) if you encounter build issues
- **Coverage not showing**: Ensure your tests are in `src/test/java/triangle/TriangleTest.java`
