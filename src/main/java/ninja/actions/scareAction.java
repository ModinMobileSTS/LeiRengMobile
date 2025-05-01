package ninja.actions;

import ninja.enums.LibraryTypeEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.UnlimboAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

import java.util.ArrayList;
import java.util.List;

public class scareAction extends AbstractGameAction {

    private int amount;

    public scareAction(int amount) {
        this.amount = amount;
    }

    public void update() {
        //读取忍术卡
        List<AbstractCard> ninjutsuCards = new ArrayList<>();
        for (AbstractCard c : CardLibrary.getCardList(LibraryTypeEnum.SILVER)) {
            if (c.tags.contains(AbstractCard.CardTags.NINJUTSU) && c.rarity != AbstractCard.CardRarity.BASIC) {
                ninjutsuCards.add(c);
            }
        }
        if (!ninjutsuCards.isEmpty()) {
            //随机释放忍术
            for (int i = 0; i < this.amount; i++) {
                this.addToTop(new PlaySoundAction("Pick"));
                int randomIndex = AbstractDungeon.cardRandomRng.random(ninjutsuCards.size() - 1);
                AbstractCard randomNinjutsu = ninjutsuCards.get(randomIndex).makeCopy();
                AbstractCard card = randomNinjutsu;
                AbstractDungeon.player.drawPile.group.remove(card);
                AbstractDungeon.getCurrRoom().souls.remove(card);
                card.exhaustOnUseOnce = true;
                AbstractDungeon.player.limbo.group.add(card);
                card.current_y = -200.0F * Settings.scale;
                card.target_x = (float) Settings.WIDTH / 2.0F + 200.0F * Settings.xScale;
                card.target_y = (float) Settings.HEIGHT / 2.0F;
                card.targetAngle = 0.0F;
                card.lighten(false);
                card.drawScale = 0.12F;
                card.targetDrawScale = 0.75F;
                card.applyPowers();
                this.addToTop(new NewQueueCardAction(card, AbstractDungeon.getCurrRoom().monsters.getRandomMonster((AbstractMonster) null, true, AbstractDungeon.cardRandomRng), false, true));
                this.addToTop(new UnlimboAction(card));
                if (!Settings.FAST_MODE) {
                    this.addToTop(new WaitAction(Settings.ACTION_DUR_MED));
                } else {
                    this.addToTop(new WaitAction(Settings.ACTION_DUR_FASTER));
                }

            }
        }



        this.isDone =true;
    }
}
