# Withernauts

## Development Environment
1. Click Gradle > forgegradle > setupDecompWorkspace
2. Click build runClient

## Known Issues

### Incompatible IDEA Runtime
Error: `The project uses Gradle 2.14 which is incompatible with IDEA running on Java 10 or newer.`

Solution:
    1. Install the [Choose Runtime Plugin](https://plugins.jetbrains.com/plugin/12836-choose-runtime)
    2. **Find Action** (Ctrl+Shift+A) -> Choose Runtime
    3. Select Java 1.8

