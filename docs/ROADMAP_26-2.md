# Roadmap — The Sundering (NeoForge 26.2)

> **Fecha**: 2026-08-18
> **Estado base**: Fase 0 completada, Fases 1, 2, 4 completadas (commits locales). Port de 839 clases Java desde L_Ender's Cataclysm 3.32 (descompilado CFR).
> **Objetivo**: Versión beta estable para CurseForge (v1.0.0-beta.1).

---

## ✅ COMPLETADO (2026-08-18)

| Fase | Tarea | Archivos modificados |
|------|-------|---------------------|
| **1** | Curios dependency: build.gradle + neoforge.mods.toml + copy jar to libs/ | `build.gradle`, `src/main/resources/templates/META-INF/neoforge.mods.toml`, `libs/curios-neoforge-15.0.0-beta.2+26.2.jar` |
| **2** | Mixins fix: 19 common + 2 client mixins + refmap.json | `src/main/resources/the_sundering.mixins.json`, `src/main/resources/the_sundering.refmap.json` |
| **4** | Verificación estructura de build y dependencias | — |

---

## 📊 PORT COVERAGE vs ORIGINAL (Cataclysm 3.32)

| Sistema | Clases Original | Archivos Port | Cobertura |
|---------|----------------|---------------|-----------|
| Entities (mobs, proyectiles, efectos, pets, bosses) | 200+ | 177 | ~95% |
| Items (armas, armaduras, curios, tools) | 60+ | 67 | ~100% |
| Blocks (altares, trampas, estructuras, decor) | 40+ | 28 | ~90% |
| BlockEntities | 15+ | 14 | ~95% |
| Client/Animations (LionfishAPI → NautilusAPI) | 30+ | 403 | ~100% |
| Structures/Jigsaw | 25+ | 20 | ~90% |
| World Gen | 15+ | 21 | ~100% |
| Networking (15 paquetes) | 15 | 15 | ~100% |
| Mixins/Accessors | 21 | 23 | ~100% |
| JEI/Recipes | 5+ | 5 | ~100% |
| Data Components/Attachments | 4+ | 4 | ~100% |

**Total**: 839 archivos Java en `com.skd.thesundering.*`

---

## 🗺️ ROADMAP POR FASES

### **FASE 1: COMPILACIÓN LIMPIA** 🎯 *Próxima (1-2 días)*

| Tarea | Archivos/Riesgo |
|-------|-----------------|
| `./gradlew clean build` | **ALTO** - detecta errores API 26.2 reales |
| Fix deprecations/breaking changes | `entity/`, `client/`, `world/` (Medio) |
| `ModItems::modifyComponents` (Data Components 1.21.4+) | `init/ModItems.java` (Alto) |
| `ModDataComponents` vs `ModDataAttachments` | `init/` (Medio) |
| Validar DeferredRegister (namespace "cataclysm") | `init/*.java` (Bajo) |

**Criterio**: `BUILD SUCCESSFUL` sin warnings críticos.

---

### **FASE 2: RUNTIME BÁSICO** 🎮 *(2-3 días)*

| Tarea | Validación |
|-------|------------|
| `runClient` - carga menú principal | Sin crashes en startup |
| `runServer` - genera mundo | Sin errores en consola |
| Spawn entidades clave (Leviathan, Maledictus, Clawdian) | `/summon cataclysm:...` |
| Items/armas en creative | Pestaña "The Sundering" |
| Bloques/estructura (Altars, Traps) | Colocación + función |

**Criterio**: Mundo se genera, entidades spawnean, items funcionan.

---

### **FASE 3: SISTEMAS COMPLEJOS** ⚙️ *(3-5 días)*

| Sistema | Puntos de verificación |
|---------|------------------------|
| **Animaciones (NautilusAPI)** | Modelos `.geo.json` cargan, animaciones reproducen |
| **Curios integration** | Slots curios visibles, items equipables |
| **Jigsaw/Structures** | `/place template cataclysm:...` genera ruinas |
| **Bossbars/Networking** | Mensajes `MessageBossBar`, `MessageCharge` sincronizan |
| **Data Components 1.21.4** | `ModItems::modifyComponents` aplica correctamente |
| **JEI Recipes** | Categorías Altar/Weaponfusion visibles |

---

### **FASE 4: PULIDO & CALIDAD** ✨ *(2-3 días)*

| Área | Acciones |
|------|----------|
| **Config** | `ConfigHolder` CLIENT/COMMON TOML válidos |
| **Localización** | `en_us.json` + `es_es.json` completos |
| **Assets** | Texturas, modelos, sonidos sin missing |
| **Performance** | Profile mixins, entity tick, render layers |
| **Crash fixes** | Try/catch en puntos frágiles (spawn, render) |

---

### **FASE 5: RELEASE PREP** 📦 *(1 día)*

| Entregable | Detalle |
|------------|---------|
| **JAR firmado** | `./gradlew build` → `build/libs/the_sundering-26.2-...jar` |
| **Changelog** | `CHANGELOG.md` v0.0.0-beta.3 → v1.0.0-beta.1 |
| **README** | Descripción, dependencias, issue tracker, licencia |
| **CurseForge metadata** | `neoforge.mods.toml` versionRange, displayURL, logo |
| **Test final** | Instalar JAR en perfil limpio + jugar 30 min |

---

## 🚨 RIESGOS CRÍTICOS

| Riesgo | Impacto | Mitigación |
|--------|---------|------------|
| API cambios 26.2 (registries, data components) | Build fail / runtime crash | Revisar `ModItems::modifyComponents`, `ModDataComponents` |
| NautilusAPI incompleto | Animaciones rotas | Verificar `AnimationMessage` + `PayloadRegistrar` |
| Curios beta API | Slots no aparecen | Testear `CuriosApi.getCuriosInventory()` |
| Mixin refmap vacío | Crashes en obfuscation | Generar con `gradlew genRefmap` o completar manual |
| Jigsaw/Structure API | Estructuras no generan | Validar `ModStructures` + `ModJigsaw` registration |

---

## 📅 CRONOGRAMA ESTIMADO

| Fase | Duración | Acumulado |
|------|----------|-----------|
| Fase 1: Compilación | 1-2 días | **Día 2** |
| Fase 2: Runtime básico | 2-3 días | **Día 5** |
| Fase 3: Sistemas complejos | 3-5 días | **Día 10** |
| Fase 4: Pulido | 2-3 días | **Día 13** |
| Fase 5: Release prep | 1 día | **Día 14** |

**Total estimado: 2 semanas** para versión beta estable lista para CurseForge.

---

## 🎯 PRÓXIMO PASO INMEDIATO

```bash
cd G:\Proyectos\Mods_Minecraft\the_sundering\neoforge\26.2
./gradlew clean build --stacktrace 2>&1 | tail -100
```

---

## 📝 NOTAS OPERATIVAS

- **Rama actual**: `minecraft/26.2/neoforge-26.2.0.45-beta/production`
- **mod_version**: `0.0.0-beta.3` (actualizar a `1.0.0-beta.1` en Fase 5)
- **Dependencias locales**: `libs/nautilus_api-*.jar`, `libs/curios-neoforge-15.0.0-beta.2+26.2.jar`
- **Original jar**: `lib_ext/L_Ender's Cataclysm 1.21.1-3.32.jar` (referencia, no versionado)
- **Permiso autor**: Confidencial — no mencionar en archivos públicos (README, CHANGELOG, mods.toml)
- **Licencia**: CC BY-NC-ND 4.0 (no relicenciar sin confirmar con usuario)

---

## 🔗 ARCHIVOS RELACIONADOS

- `docs/WORKFLOW_THE_SUNDERING_26-2.md` — Workflow operativo completo
- `docs/curseforge/project_vars.md` — Variables CurseForge (pendiente creación proyecto)
- `temp/cataclysm_port_fase0/FASE0_REPORT_CATACLYSM.md` — Diagnóstico Fase 0 (fuera del repo)
- `temp/cataclysm_port_fase0/FASE1_PLAN_CATACLYSM.md` — Plan Fase 1 detallado (fuera del repo)