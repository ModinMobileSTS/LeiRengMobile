package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.ShitPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class GonnaEatShit extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GonnaEatShit");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/GonnaEatShit.png";
    public static final String ID = "GonnaEatShit";

    public GonnaEatShit() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
        this.exhaust = true;
        this.baseDamage = 3;
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m){
                this.addToBot(new DamageAction(p, new DamageInfo(p, this.damage, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.POISON));
        this.addToBot(new ApplyPowerAction(p,p, new ShitPower(p,this.magicNumber)));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(2);
            this.upgradeDamage(-1);
        }
    }

    public AbstractCard makeCopy(){
        return new GonnaEatShit();
    }
}
