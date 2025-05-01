package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.PoisonFlameAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;

public class FlameThrower extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FlameThrower");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/FlameThrower.png";
    public static final String ID = "FlameThrower";

    public FlameThrower(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        this.baseMagicNumber = 4;
        this.baseDamage = 8;
        this.magicNumber = this.baseMagicNumber;
        this.isMultiDamage = true;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        this.addToBot(new VFXAction(p, new InflameEffect(p), 0.2F));
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage,this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        this.addToBot(new NinjutsuAction(p , new PoisonFlameAction(p,this.magicNumber),1,"FlameThrower"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
            this.upgradeDamage(2);
        }
    }
}
