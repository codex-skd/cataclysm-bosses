#!/bin/bash
# Fix all projectile files for NeoForge 26.2 / 1.21.4

for f in *.java; do
    # Skip already fixed files
    if [[ "$f" == "Wither_Missile_Entity.java" ]] || \
       [[ "$f" == "AbstractElemental_Spear.java" ]] || \
       [[ "$f" == "CMAbstractHurtingProjectile.java" ]] || \
       [[ "$f" == "Axe_Blade_Entity.java" ]]; then
        continue
    fi
    
    echo "Fixing $f..."
    
    # 1. Remove hurt() method (final in Entity)
    sed -i '/public boolean hurt(DamageSource/,/^[[:space:]]*}/d' "$f"
    
    # 2. Fix recreateFromPacket - replace getXa()/getYa()/getZa() with getMovement()
    sed -i 's/Vec3 vec3 = new Vec3(packet.getXa(), packet.getYa(), packet.getZa());/Vec3 vec3 = packet.getMovement();/' "$f"
    sed -i 's/double d0 = packet.getXa();/double d0 = vec3.x();/' "$f"
    sed -i 's/double d1 = packet.getYa();/double d1 = vec3.y();/' "$f"
    sed -i 's/double d2 = packet.getZa();/double d2 = vec3.z();/' "$f"
    
    # 3. Remove hasImpulse = true
    sed -i '/this.hasImpulse = true;/d' "$f"
    
    # 4. Fix onDeflection - remove super.onDeflection call
    sed -i 's/super.onDeflection(entity, deflectedByPlayer);//' "$f"
    
    # 5. Remove checkDespawn and removeWhenFarAway if they exist (final in 1.21.4?)
    # These might be fine to keep, but let's check
done
echo "Done"
